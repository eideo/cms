package com.sbiao360.cms.zutil;

//import java.io.*;

public final class Base64 {

	final private static int BUFFER_SIZE = 40960;
	final static int max_octet_line = 76;
	final static short buffer_size = 2048;
	final static byte codes[] =
		{
			(byte) 'A',
			(byte) 'B',
			(byte) 'C',
			(byte) 'D',
			(byte) 'E',
			(byte) 'F',
			(byte) 'G',
			(byte) 'H',
			(byte) 'I',
			(byte) 'J',
			(byte) 'K',
			(byte) 'L',
			(byte) 'M',
			(byte) 'N',
			(byte) 'O',
			(byte) 'P',
			(byte) 'Q',
			(byte) 'R',
			(byte) 'S',
			(byte) 'T',
			(byte) 'U',
			(byte) 'V',
			(byte) 'W',
			(byte) 'X',
			(byte) 'Y',
			(byte) 'Z',
			(byte) 'a',
			(byte) 'b',
			(byte) 'c',
			(byte) 'd',
			(byte) 'e',
			(byte) 'f',
			(byte) 'g',
			(byte) 'h',
			(byte) 'i',
			(byte) 'j',
			(byte) 'k',
			(byte) 'l',
			(byte) 'm',
			(byte) 'n',
			(byte) 'o',
			(byte) 'p',
			(byte) 'q',
			(byte) 'r',
			(byte) 's',
			(byte) 't',
			(byte) 'u',
			(byte) 'v',
			(byte) 'w',
			(byte) 'x',
			(byte) 'y',
			(byte) 'z',
			(byte) '0',
			(byte) '1',
			(byte) '2',
			(byte) '3',
			(byte) '4',
			(byte) '5',
			(byte) '6',
			(byte) '7',
			(byte) '8',
			(byte) '9',
			(byte) '+',
			(byte) '/',
			(byte) '=' };

	final private static byte isCode(byte b) {
		if (b >= 'A' && b <= 'Z') {
			return (byte) (b - 'A');
		} else if (b >= 'a' && b <= 'z') {
			return (byte) (b - 'a' + 26);
		} else if (b >= '0' && b <= '9') {
			return (byte) (b - '0' + 52);
		} else if (b == '+')
			return (byte) 62;
		else if (b == '/')
			return (byte) 63;
		else if (b == '=')
			return (byte) 64;
		else
			return (byte) 65;
	}

	public static byte[] encodeBinary(byte input[]) {
		if (input == null)
			return null;
		int i, value = 0, allocated, encoded;
		short bytes, lineLen, j;
		byte buf[] = new byte[buffer_size], temp[];
		allocated = buffer_size;
		for (i = encoded = bytes = lineLen = 0; i < input.length; ++i) {
			if (bytes == 0) {
				value = input[i];
				++bytes;
			} else if (bytes == 1) {
				value <<= 8;
				value |= (input[i] & 0xff);
				++bytes;
			} else if (bytes == 2) {
				value <<= 8;
				value |= (input[i] & 0xff);
				bytes = 0;
				for (j = 3; j >= 0; --j) {
					if (lineLen >= max_octet_line) {
						if (encoded >= allocated) {
							temp = new byte[allocated + buffer_size];
							System.arraycopy(buf, 0, temp, 0, allocated);
							allocated += buffer_size;
							buf = temp;
						}
						buf[encoded++] = (byte) '\r';
						if (encoded >= allocated) {
							temp = new byte[allocated + buffer_size];
							System.arraycopy(buf, 0, temp, 0, allocated);
							allocated += buffer_size;
							buf = temp;
						}
						buf[encoded++] = (byte) '\n';
						lineLen = 0;
					}
					if (encoded >= allocated) {
						temp = new byte[allocated + buffer_size];
						System.arraycopy(buf, 0, temp, 0, allocated);
						allocated += buffer_size;
						buf = temp;
					}
					buf[encoded++] = codes[(value >> j * 6) & 0x3f];
					++lineLen;
				}
			}
		}
		if (bytes == 1) {
			value <<= 4;
			for (j = 1; j >= 0; --j) {
				if (lineLen >= max_octet_line) {
					if (encoded >= allocated) {
						temp = new byte[allocated + buffer_size];
						System.arraycopy(buf, 0, temp, 0, allocated);
						allocated += buffer_size;
						buf = temp;
					}
					buf[encoded++] = (byte) '\r';
					if (encoded >= allocated) {
						temp = new byte[allocated + buffer_size];
						System.arraycopy(buf, 0, temp, 0, allocated);
						allocated += buffer_size;
						buf = temp;
					}
					buf[encoded++] = (byte) '\n';
					lineLen = 0;
				}
				if (encoded >= allocated) {
					temp = new byte[allocated + buffer_size];
					System.arraycopy(buf, 0, temp, 0, allocated);
					allocated += buffer_size;
					buf = temp;
				}
				buf[encoded++] = codes[(value >> j * 6) & 0x3f];
				++lineLen;
			}
			// pad one '='
			if (lineLen >= max_octet_line) {
				if (encoded >= allocated) {
					temp = new byte[allocated + buffer_size];
					System.arraycopy(buf, 0, temp, 0, allocated);
					allocated += buffer_size;
					buf = temp;
				}
				buf[encoded++] = (byte) '\r';
				if (encoded >= allocated) {
					temp = new byte[allocated + buffer_size];
					System.arraycopy(buf, 0, temp, 0, allocated);
					allocated += buffer_size;
					buf = temp;
				}
				buf[encoded++] = (byte) '\n';
				lineLen = 0;
			}
			if (encoded >= allocated) {
				temp = new byte[allocated + buffer_size];
				System.arraycopy(buf, 0, temp, 0, allocated);
				allocated += buffer_size;
				buf = temp;
			}
			buf[encoded++] = codes[64];
			++lineLen;
			// pad another '='
			if (lineLen >= max_octet_line) {
				if (encoded >= allocated) {
					temp = new byte[allocated + buffer_size];
					System.arraycopy(buf, 0, temp, 0, allocated);
					allocated += buffer_size;
					buf = temp;
				}
				buf[encoded++] = (byte) '\r';
				if (encoded >= allocated) {
					temp = new byte[allocated + buffer_size];
					System.arraycopy(buf, 0, temp, 0, allocated);
					allocated += buffer_size;
					buf = temp;
				}
				buf[encoded++] = (byte) '\n';
				lineLen = 0;
			}
			if (encoded >= allocated) {
				temp = new byte[allocated + buffer_size];
				System.arraycopy(buf, 0, temp, 0, allocated);
				allocated += buffer_size;
				buf = temp;
			}
			buf[encoded++] = codes[64];
		} else if (bytes == 2) {
			value <<= 2;
			for (j = 2; j >= 0; --j) {
				if (lineLen >= max_octet_line) {
					if (encoded >= allocated) {
						temp = new byte[allocated + buffer_size];
						System.arraycopy(buf, 0, temp, 0, allocated);
						allocated += buffer_size;
						buf = temp;
					}
					buf[encoded++] = (byte) '\r';
					if (encoded >= allocated) {
						temp = new byte[allocated + buffer_size];
						System.arraycopy(buf, 0, temp, 0, allocated);
						allocated += buffer_size;
						buf = temp;
					}
					buf[encoded++] = (byte) '\n';
					lineLen = 0;
				}
				if (encoded >= allocated) {
					temp = new byte[allocated + buffer_size];
					System.arraycopy(buf, 0, temp, 0, allocated);
					allocated += buffer_size;
					buf = temp;
				}
				buf[encoded++] = codes[(value >> j * 6) & 0x3f];
				++lineLen;
			}
			// pad one '='
			if (lineLen >= max_octet_line) {
				if (encoded >= allocated) {
					temp = new byte[allocated + buffer_size];
					System.arraycopy(buf, 0, temp, 0, allocated);
					allocated += buffer_size;
					buf = temp;
				}
				buf[encoded++] = (byte) '\r';
				if (encoded >= allocated) {
					temp = new byte[allocated + buffer_size];
					System.arraycopy(buf, 0, temp, 0, allocated);
					allocated += buffer_size;
					buf = temp;
				}
				buf[encoded++] = (byte) '\n';
				lineLen = 0;
			}
			if (encoded >= allocated) {
				temp = new byte[allocated + buffer_size];
				System.arraycopy(buf, 0, temp, 0, allocated);
				allocated += buffer_size;
				buf = temp;
			}
			buf[encoded++] = codes[64];
		}
		if (encoded == 0)
			return null;
		temp = new byte[encoded];
		System.arraycopy(buf, 0, temp, 0, encoded);
		return temp;
	}

	public static byte[] decodeBinary(byte input[]) {
		if (input == null)
			return null;
		int i, decoded, value = 0, allocated;
		byte b, buf[] = new byte[buffer_size], bytes, temp[], j;
		allocated = buffer_size;
		for (i = decoded = bytes = 0; i < input.length; ++i) {
			b = isCode(input[i]);
			if (b < 64) {
				if (bytes == 3) {
					value <<= 6;
					value |= b;
					bytes = 0;
					if (decoded + 3 > allocated) {
						temp = new byte[allocated + buffer_size];
						System.arraycopy(buf, 0, temp, 0, decoded);
						allocated += buffer_size;
						buf = temp;
					}
					for (j = 2; j >= 0; --j) {
						buf[decoded++] = (byte) ((value >> j * 8) & 0xff);
					}
				} else if (bytes == 0) {
					value = b;
					++bytes;
				} else {
					value <<= 6;
					value |= b;
					++bytes;
				}
			}
		}
		if (bytes == 2) {
			if (decoded >= allocated) {
				temp = new byte[allocated + buffer_size];
				System.arraycopy(buf, 0, temp, 0, decoded);
				allocated += buffer_size;
				buf = temp;
			}
			buf[decoded++] = (byte) ((value >> 4) & 0xff);
		} else if (bytes == 3) {
			if (decoded + 2 > allocated) {
				temp = new byte[allocated + buffer_size];
				System.arraycopy(buf, 0, temp, 0, decoded);
				allocated += buffer_size;
				buf = temp;
			}
			value >>= 2;
			buf[decoded++] = (byte) ((value >> 8) & 0xff);
			buf[decoded++] = (byte) (value & 0xff);
		}
		if (decoded == 0)
			return null;
		temp = new byte[decoded];
		System.arraycopy(buf, 0, temp, 0, decoded);
		return temp;
	}

}
