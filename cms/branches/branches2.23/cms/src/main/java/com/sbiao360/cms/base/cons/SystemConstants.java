/*
 *
 *
 *@author Marlon LI ,2013-6-3 下午02:01:31
 *
 */

package com.sbiao360.cms.base.cons;
public class SystemConstants {
 
	private static String IMAGE_PREFIX_DOMAIN = null;
	private static String ONAPIPROD_PREFIX_DOMAIN = null;
 
	/**
	 * technotes image url for non snx parts
	 */
	public static String NONSNX_TECHNOTES_IMG_URL = null;

    /**
     * LOL storefront website.
     */
    public final static String LOL_WEBSITE_SF = "lol_sf";
    /**
     * EC website.
     */
    public final static String WEBSITE_EC = "ec";
    /**
     * LOL system number.
     */
    public final static int LOL_SYSTEM_NO = 34;
    /**
     * Cansupply/Compar system number.
     */
    public final static int CSP_SYSTEM_NO = 29;
    /**
     * The default spa type for pricing.
     */
    public final static String TYPE_VENDOR_SPA = "VS";

    /**
     * Valid purchace code length.
     */
    public final static int VALID_PURCHACE_CODE_LENGTH = 20;

    /**
     * Valid first name length.
     */
    public final static int VALID_FIRST_NAME_LENGTH = 20;

    /**
     * Valid last name length.
     */
    public final static int VALID_LAST_NAME_LENGTH = 20;

    /**
     * Valid phone number length.
     */
    public final static int VALID_PHONE_NUMBER_LENGTH = 20;

    /**
     * Valid address length.
     */
    public final static int VALID_ADDRESS_LENGTH = 60;

    /**
     * Valid email address length.
     */
    public final static int VALID_EMAIL_LENGTH = 150;

    /**
     * Default password length.
     */
    public final static int DEFAULT_PASSWORD_LENGTH = 8;

    /**
     * The characters for generate new password.
     */
    public final static String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * Sales order type.
     */
    public final static int[] SALES_ORDER_TYPE = new int[] { 1, 8 };
    /**
     * Show actual inventory.
     */
    public final static int CONFIG_PART_AVAIL_INVENTORY = 1;
    /**
     * Show inventory as blank.
     */
    public final static int CONFIG_PART_AVAIL_BLANK = 2;
    /**
     * Show inventory as call.
     */
    public final static int CONFIG_PART_AVAIL_CALL = 3;
    /**
     * Show inverntory as yes.
     */
    public final static int CONFIG_PART_AVAIL_YES = 4;
    /**
     * Show inventory as call.
     */
    public final static int CONFIG_PART_AVAIL_ONE_lEAD_TIME = 5;
    /**
     * Show inverntory as yes.
     */
    public final static int CONFIG_PART_AVAIL_TWO_LEAD_TIME = 6;

    /**
     * Multiple image count.
     */
    public final static int MULTIPLE_IMAGE_COUNT = 4;
    /**
     * Shop for end user, bill to RS, copied from EC.
     */
    public final static int PO_SHOPPING_MODE_CUSTOMER_BILLTO_RS = 1;
    /**
     * Shop for end user, bill to end user, copied form EC.
     */
    public final static int PO_SHOPPING_MODE_CUSTOMER_BILLTO_EU = 2;
    /**
     * The end user shopper, copied from EC.
     */
    public final static int PO_SHOPPER_TYPE_END_USER = 2;
    /**
     * The default PO ID.
     */
    public final static int PO_ID_DEFAULT = 0;
    /**
     * The order edit flag, new is new order, copied from EC.
     */
    public final static int PO_FLAG_EDIT_NEW = 0;
    /**
     * The order edit flag, update is update order, copied from EC.
     */
    public final static int PO_FLAG_EDIT_UPDATE = 1;
    /**
     * The order edit flag, copied from EC.
     */
    public final static int PO_FLAG_EDIT_DELETE = 2;
    /**
     * The order edit flag, copied from EC.
     */
    public final static int PO_FLAG_EDIT_READ = 3;
    /**
     * PO submit status for end user billing.
     */
    public final static String PO_STATUS_QUOTEPO = "QUOTEPO";
    /**
     * PO submit status for reseller billing.
     */
    public final static String PO_STATUS_EUSUBMIT = "EUSUBMIT";
    /**
     * PO status for "save as quote".
     */
    public final static String PO_STATUS_QUTATION = "QUOTATION";
    /**
     * The PO u_version.
     */
    public final static char PO_VERSION = '!';
    /**
     * Ship to location type for end user.
     */
    public final static String PO_SHIPTO_TYPE_ENDUSER = "EU";
    /**
     * Ship to location type for reseller.
     */
    public final static String PO_SHIPTO_TYPE_RESELLER = "RS";
    /**
     * Freight pay type, copied from EC.
     */
    public final static String PO_FREIGHT_PAY_TYPE_PPI = "PPI";
    /**
     * Service messages below. Country not found message.
     */
    public final static String COUNTRY_NOT_FOUND_MESSAGE = "Country {0} not found.";
    /**
     * Invalid zip code message.
     */
    public final static String INVALID_ZIP_CODE_MESSAGE = "Invalid Zip Code (country={0},city={1},state={2},Zip Code={3})";
    /**
     * End user not found message.
     */
    public final static String ENDUSER_NOT_FOUND_MESSAGE = "User not exist";
    /**
     * Odometer not found message.
     */
    public final static String ODOMETER_NOT_FOUND_MESSAGE = "End user number not found.";
    /**
     * Email has been used message.
     */
    public final static String EMAIL_ALREADY_EXIST_MESSAGE = "This email address has already been used by another user. Please use another one.";
    /**
     * End user create fail message.
     */
    public final static String ENDUSER_CREATE_MESSAGE = "Failed to create the end user.";
    /**
     * EC user not found message.
     */
    public final static String ECUSER_NOT_FOUND_MESSAGE = "Login failed due to invalid email. Please check it.";
    /**
     * Find multiple ec users message.
     */
    public final static String MULTIPLE_EC_USERS_MESSAGE = "Based on your criteria, multiple users are found.";
    /**
     * Login disabled message.
     */
    public final static String LOGIN_DISABLED_MESSAGE = "Sorry, your login has been disabled. To fix this, please contact your administrator or reseller for your account.";
    /**
     * Too may login attempts message.
     */
    public final static String TOO_MANY_LOGIN_ATTEMPTS_MESSAGE = "You have failed to login for " + "more than {0} times. Your account has been locked. To unlock it, please contact " + "the administrator of your account. ";
    /**
     * Location not found message.
     */
    public final static String LOCATION_NOT_FOUND_MESSAGE = "Location number {0} not found.";
    /**
     * Contact not found message.
     */
    public final static String CONTACT_NOT_FOUND_MESSAGE = "Contact number {0} not found.";
    /**
     * Password not match message.
     */
    public final static String PASSWORD_NOT_MATCH_MESSAGE = "Password not match for the login";
    /**
     * Coupon code invalid message.
     */
    public final static String COUPON_CODE_INVALID_MESSAGE = "Coupon Code invalid";
    /**
     * Access code invalid message.
     */
    public final static String ACCESS_CODE_INVALID_MESSAGE = "Access code invalid";
    /**
     * Coupon code expired message.
     */
    public final static String COUPON_CODE_EXPIRED_MESSAGE = "Expired Coupon Code";
    /**
     * Customer PO not found message.
     */
    public final static String CUST_PO_NOT_FOUND_MESSAGE = "PO/Quote {0} is not found (may have been deleted or wrong PO#)";
    /**
     * Customer not found message.
     */
    public final static String CUST_NOT_FOUND_MESSAGE = "Customer {0,number,#} not found.";
    /**
     * exception resource not found message .
     */
    public final static String EXCEPTION_RESOURCE_NOT_FOUND_MESSAGE = "Cannot find template {0}.";
    /**
     * exception parse erro rmessage.
     */
    public final static String EXCEPTION_PARSE_ERROR_MESSAGE = "Syntax error in template {0}.";

    /**
     * mail subject retrieve.
     */
    public final static String MAIL_SUBJECT_RETRIEVEPWD = "Retrieve password";
    /**
     * mail subject order confirm.
     */
    public final static String MAIL_SUBJECT_ORDERCONFIRM = "{0} Order Confirmation (Confirmation# {1})";
    /**
     * mail subject eu submit order.
     */
    public final static String MAIL_SUBJECT_EUSUBMIT = "{0} EUSubmitted Order pending (Confirmation# {1})";
    /**
     * mail subject registration.
     */
    public final static String MAIL_SUBJECT_REGISTRATION = "Your login for {0}";
    /**
     * mail subject password create.
     */
    public final static String MAIL_SUBJECT_PASSWORD_CREATE = "{0} password created";
    /**
     * mail_mime_type_text_html.
     */
    public final static String MAIL_MIME_TYPE_TEXT_HTML = "text/html";
    /**
     * mail_mime_type_text_plain.
     */
    public final static String MAIL_MIME_TYPE_TEXT_PLAIN = "text/plain";
    /**
     * mail_line_separator.
     */
    public final static String MAIL_LINE_SEPARATOR = "\n";
    /**
     * mail_delimiter.
     */
    public final static String MAIL_DELIMITER = ";";
    /**
     * CONFIG_PREFIX_creditCard
     */
    public final static String CONFIG_PREFIX_creditCard = "cc";
    /**
     * Credit Card validation failed message.
     */
    public final static String CREDIT_CARD_VALIDATION_FAILED = "Failed to verify credit card {0}!";
    /**
     * Credit Card type is valid message.
     */
    public final static String CREDITCARD_no_type_INVALID = "Card# is invalid (should start with {0})";
    /**
     * Credit Card expired message.
     */
    public final static String CREDITCARD_expired = "Credit Card has expired.";
    /**
     * Order tracking url prefix.
     */
    public final static String ORDER_TRACKING_URL_PRE = "order.trackingURL.";
    /**
     * American Express.
     */
    public final static String CODE_AMERICAN_EXPRESS = "AE";
    /**
     * Master/Visa card.
     */
    public final static String CODE_MASTER_VISA_CARD = "MV";
    /**
     * Master card.
     */
    public final static String CODE_MASTER_CARD = "MC";
    /**
     * Visa card.
     */
    public final static String CODE_VISA_CARD = "VS";
    /**
     * Discover card term
     */
    public final static String CODE_DISCOVER_CARD_TERM = "DVR";
    /**
     * Discover card
     */
    public final static String CODE_DISCOVER_CARD = "DV";
    /**
     * microsoft credit card
     */
    public final static String CODE_MICROSOFT_CREDIT_CARD = "MCC";
    /**
     * master card description.
     */
    public final static String CODE_MASTER_CARD_DESC = "Master Card";
    /**
     * visa card description.
     */
    public final static String CODE_VISA_CARD_DESC = "VISA";
    /**
     * default logo name to identify if display first and second logo.
     */
    public final static String DEFAULT_LOGO_NAME = "default/images/logo.gif";
    /**
     * The default store end user number, used for multiple EUs.
     */
    public final static int DEFAULT_STORE_EU = -1;
    /**
     * The default customer number for session user.
     */
    public final static int DEFAULT_CUST_NO = -1;

    /**
     * The default store ID.
     */
    public final static int DEFAULT_STORE_ID = -1;
    /**
     * product category type for popular products.
     */
    public final static String CATEGORY_TYPE_POPULAR = "Popular Products";
    /**
     * product small image url.
     */
    public final static String PRODUCT_IMAGE_SMALL = String.format("http://%s/small_image_technote/", ONAPIPROD_PREFIX_DOMAIN);
    /**
     * product image url.
     */
    public final static String PRODUCT_IMAGE = String.format("http://%s/image_technote/", ONAPIPROD_PREFIX_DOMAIN);

    /**
     * ship confirmation id.
     */
    public final static int SHIP_CONFIRMATION_VALUE = 0x04;


    // the roles and resources.
    /**
     * super user role, for the end user billing and no eu assigned store.
     */
    public final static String ROLE_SUPER_USER = "superuser";
    /**
     * end user billing and eu assigned store.
     */
    public final static String ROLE_EUB_USER = "eubuser";
    /**
     * reseller billing store.
     */
    public final static String ROLE_RSB_USER = "rsbuser";
    /**
     * reseller billing and eu assigned store.
     */
    public final static String ROLE_RSB_LIMIT_USER = "rsblimituser";
    /**
     * the registration link.
     */
    public final static String RESOURCE_LINK_REGISTRATION = "link.register";
    /**
     * the address link.
     */
    public final static String RESOURCE_LINK_ADDRESS = "link.address";
    /**
     * the address select link.
     */
    public final static String RESOURCE_LINK_ADDRESS_SELECT = "link.address.popup";
    /**
     * the payment panel.
     */
    public final static String RESOURCE_PANEL_PAYMENT = "paymentPanel";
    /**
     * the register panel.
     */
    public final static String RESOURCE_PANEL_REGISTER = "registerPanel";
    /**
     * the amount label on order history page.
     */
    public final static String RESOURCE_LABEL_AMOUNT = "label.amount";
    /**
     * the store ID parameter.
     */
    public final static String STORE_ID_PARAM="storeID";
    /**
     * prefix for store id.
     */
    public final static String STORE_ID_PREFIX = "store";
    /**
     * no image url.
     */
    public final static String NO_IMAGE_URL = String.format("http://%s/lol_storefront/gstore/resources/PROD/default/images/no_image.gif", IMAGE_PREFIX_DOMAIN);
    /**
     * default banner url.
     */
    public final static String DEFAULT_BANNER_URL = String.format("http://%s/lol_storefront/gstore/resources/PROD/default/images/banner.gif", IMAGE_PREFIX_DOMAIN);
    /**
     * default location name.
     */
    public final static String DEFAULT_LOCATION_NAME="#MY ACCOUNT#";
    /**
     * default user resource URL.
     */
    public final static String DEFAULT_USER_RESOURCE_URL = String.format("http://%s/lol_storefront/gstore/users/PROD", IMAGE_PREFIX_DOMAIN);
    /**
     * default resource path.
     */
    public final static String DEFAULT_RESOURCE_URL = String.format("http://%s/lol_storefront/gstore/resources/PROD/default/", IMAGE_PREFIX_DOMAIN);
    /**
     * default credit card statement.
     */
    public final static String DEFAULT_CC_STATEMENT="License Online Corporation";
    /**
     * store cookie name.
     */
    public final static String STORE_COOKIE_NAME="store";
    /**
     * max cookie age 7 * 24 * 60 * 60.
     */
    public final static int COOKIE_MAX_AGE=604800;
    /**
     * min cookie age.
     */
    public final static int COOKIE_MIN_AGE=0;
    /**
     * cookie path.
     */
    public final static String COOKIE_PATH="/";

    /**
     * user id cookie name.
     */
    public final static String USER_ID_COOKIE_NAME="userID";
    /**
     * store not setup message.
     */
    public final static String STORE_NOT_EXIST_MESSAGE="Your store is under construction.";
    /**
     * pagination size for product.
     */
    public final static int PRODUCT_PAGINATION_SIZE = 20;
    /**
     * default begin search offset
     */
    public final static int PRODUCT_BEGIN_OFFSET = 0;

    /**
     * user category search by sku.
     */
    public final static int CAT_SEARCH_BY_SKU = 1;
    /**
     * user category search by vendor.
     */
    public final static int CAT_SEARCH_BY_VENDOR = 2;
    /**
     * from app to call search engine.
     */
    public final static String FROMAPP_TC_EC = "TC_EC";
    /**
     * default date format.
     */
    public final static String DATE_FORMAT = "MM/dd/yyyy";
    /**
     * detail date format.
     */
    public final static String DATE_FORMAT_DETAIL = "MM/dd/yyyy hh:mma";
    /**
     * GREEN_PART_EPEAT
     */
    public static final String GREEN_PART_EPEAT = "EPEAT";
    /**
     * GREEN_PART_ENERGYSTAR
     */
    public static final String GREEN_PART_ENERGYSTAR = "EnergyStar";
    /**
     * GREEN_PART_CLIMATESAVERS
     */
    public static final String GREEN_PART_CLIMATESAVERS = "ClimateSavers";
    /**
     * EXCLUDED_PART_NOTES
     */
    public static final String  EXCLUDED_PART_NOTES = "These Products are excluded - please check with your store admin.";
    /**
     * non-SNX part source code.
     */
    public static final int SOURCE_CODE_NON_SNX = 999;
    /**
     * SNX part source code.
     */
    public static final int SOURCE_CODE_SNX = 0;
    /**
     * global/non-SNX part profile type.
     */
    public static final String GLOBAL_PART_PROFILE_TYPE = "GP";
    /**
     * default category for non-SNX part.
     */
    public static final String TBD_CATEGORY = "To Be Determined";
    /**
     * TBD two level family ID.
     */
    public static final int TBD_FAMILY_ID=20;
    /**
     * TBD two level category ID.
     */
    public static final int TBD_CATEGORY_ID=999;
    /**
     * default int value.
     */
    public static final int DEFAULT_INTEGER = 0;
    /**
     * Free ship method.
     */
    public static final String SHIP_FREIGHT_FREE = "Free";
    /**
     * TBD freight.
     */
    public static final String SHIP_FREIGHT_TBD = "$(TBD)";
    /**
     * email comments for order track.
     */
    public static final String ORDER_TRACK_EMAIL="Order track emails:";
    /**
     * The file suffix for jpg.
     */
    public static final String SUFFIX_JPG = ".jpg";
    /**
     * File type of flash
     */
    public static final String SWF_FILE_TYPE = "swf";
    /**
     * search by store catalog.
     */
    public static final String SEARCH_CATALOG_BY_STORE = "s";
    /**
     * search by full catalog.
     */
    public static final String SEARCH_CATALOG_BY_FULL = "f";
    /**
     * search by page type.
     */
    public static final String SEARCH_CATALOG_BY_PAGE_TYPE_DETAIL = "D";
    /**
     * search by page type.
     */
    public static final String SEARCH_CATALOG_BY_PAGE_TYPE_SUMMARY = "S";
    /**
     * US country code.
     */
    public static final String COUNTRY_US = "US";
    /**
     * CA country code.
     */
    public static final String COUNTRY_CA = "CA";
    /**
     * internal IP list
     */
    public final static String INTERNAL_IP_LIST = "127"+"."+"0"+"."+"0"+"."+"1"+";"+"192"+"."+"168"+"."+";"+"localhost" + ";" + "172"+"."+"16" + ".";
    /**
     * EU submit order status.
     */
    public final static String EUSUBMIT_STATUS = "Pending Reseller Approval";
    /**
     * QUOTE order status.
     */
    public final static String QUOTE_STATUS = "QUOTATION";
    /**
     * save quote action.
     */
    public final static String ACTION_SAVE_QUOTE = "saveQuote";
    /**
     * save quote action to web service.
     */
    public final static String ACTION_SAVE_QUOTE_TO_WS = "saveAndSubmit";
}
