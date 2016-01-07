/* 
 * @Author: Administrator
 * @Date:   2015-11-10 08:59:29
 * @Last Modified by:   Administrator
 * @Last Modified time: 2015-11-12 17:24:33
 */

'use strict';

var setting = {
    selector: '#chart1',
    width: 460,
    height: 460,
    margin: {
        left: 10,
        right: 10,
        top: 10,
        bottom: 10
    },
    outerRadius: 150,
    innerRadius: 100,
    dataset: [{
        name: '交通',
        value: 17.04
    }, {
        name: '机电',
        value: 20
    }, {
        name: '建筑',
        value: 10
    }, {
        name: '化工',
        value: 20
    }, {
        name: '能源',
        value: 25
    }, {
        name: '医疗',
        value: 10
    }],
    colorset: ['#ff5256', '#25cbc1', '#38e5ff', '#ffa938', '#fce22a', '#4ad486', '#FD8C84']
}

Chart.pieEmpty(setting)

var setting2 = {
    selector: '#chart2',
    radius: 5,
    width: 460,
    height: 300,
    legend:['交通','机电'],
    series: [
        [{
            time: '20140915',
            value: 1000
        }, {
            time: '20141015',
            value: 2300
        }, {
            time: '20141115',
            value: 3500
        }, {
            time: '20141215',
            value: 3600
        }, {
            time: '20150115',
            value: 3780
        }, {
            time: '20150215',
            value: 4100
        }, {
            time: '20150315',
            value: 4300
        }, {
            time: '20150415',
            value: 4500
        }, {
            time: '20150515',
            value: 4500
        }, {
            time: '20150615',
            value: 5800
        }, {
            time: '20150715',
            value: 3100
        }, {
            time: '20150815',
            value: 2800
        }],
        [{
            time: '20140915',
            value: 500
        }, {
            time: '20141015',
            value: 3300
        }, {
            time: '20141115',
            value: 4500
        }, {
            time: '20141215',
            value: 6600
        }, {
            time: '20150115',
            value: 3780
        }, {
            time: '20150215',
            value: 4100
        }, {
            time: '20150315',
            value: 4300
        }, {
            time: '20150415',
            value: 4500
        }, {
            time: '20150515',
            value: 8500
        }, {
            time: '20150615',
            value: 5800
        }, {
            time: '20150715',
            value: 3100
        }, {
            time: '20150815',
            value: 2800
        }]
    ],
    margin: {
        top: 20,
        right: 20,
        bottom: 40,
        left: 60
    },
    colorset: ['#ff5256', '#25cbc1', '#38e5ff', '#ffa938', '#fce22a', '#4ad486', '#FD8C84']
}


Chart.brokeArea(setting2)

var chart3Setting = {
    selector: '#chart3',
    radius: 5,
    width: 400,
    height: 260,
    legend:['交通','机电'],
    series: [
        [{
            time: '20140915',
            value: 1000
        }, {
            time: '20141015',
            value: 2300
        }, {
            time: '20141115',
            value: 3500
        }, {
            time: '20141215',
            value: 3600
        }, {
            time: '20150115',
            value: 3780
        }, {
            time: '20150215',
            value: 4100
        }, {
            time: '20150315',
            value: 4300
        }, {
            time: '20150415',
            value: 4500
        }, {
            time: '20150515',
            value: 4500
        }, {
            time: '20150615',
            value: 5800
        }, {
            time: '20150715',
            value: 3100
        }, {
            time: '20150815',
            value: 2800
        }],
        [{
            time: '20140915',
            value: 500
        }, {
            time: '20141015',
            value: 3300
        }, {
            time: '20141115',
            value: 4500
        }, {
            time: '20141215',
            value: 6600
        }, {
            time: '20150115',
            value: 3780
        }, {
            time: '20150215',
            value: 4100
        }, {
            time: '20150315',
            value: 4300
        }, {
            time: '20150415',
            value: 4500
        }, {
            time: '20150515',
            value: 8500
        }, {
            time: '20150615',
            value: 5800
        }, {
            time: '20150715',
            value: 3100
        }, {
            time: '20150815',
            value: 2800
        }]
    ],
    margin: {
        top: 20,
        right: 20,
        bottom: 40,
        left: 60
    },
    rectWidth: 10,
    colorset: ['#ff5256', '#25cbc1', '#38e5ff', '#ffa938', '#fce22a', '#4ad486', '#FD8C84']
}

Chart.muiltBar(chart3Setting)

var mapSetting = {
    selector: '#map',
    width: 800,
    height: 500,
    margin: {
        left: 20,
        right: 20,
        top: 20,
        bottom: 20
    },
    dataset: [

        ["乌鲁木齐", 4000,'建筑生活日测试测试测试'],
        ["苏州", 133576,'互联网大数据分析'],
        ["上海", 99647,'建筑生活日'],
        ["广州", 82592,'互联网大数据'],
        ["杭州", 61728,"互联网大数据"],
        ["成都", 27424,"互联网大数据"],
        ["北京", 24841,"互联网大数据"],
        ["青岛", 20293,"互联网大数据"],
        ["武汉", 16488,'建筑生活日'],
        ["大连", 15027,'建筑生活日'],
        ["秦皇岛", 11892,'建筑生活日'],
        ["哈尔滨", 9670,'建筑生活日'],
        ["黄山", 9177,'建筑生活日'],
        ["三亚", 8805,'建筑生活日'],
        ["大理", 7875,'建筑生活日'],
        ["重庆", 7850,'建筑生活日'],
        ["天津", 7671,'建筑生活日']
    ],
    colorset: ['#55b9fe', '#fff']
}



$(document).ready(function() {

    Chart.chinaMap(mapSetting)

    $('#chart1').find('path').click(function(e) {

        var e = e || window.event
        var index = $(this).parent().index()

        /*$.get('./public/data/data.json',function(data) {*/

        Chart.brokeArea(setting2)
        Chart.muiltBar(chart3Setting)
            /*   })*/

        e.preventDefault()
        e.stopPropagation()
    })

})