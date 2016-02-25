/* 
 * @Author: Administrator
 * @Date:   2015-11-10 08:59:29
 * @Last Modified by:   zhanganchun
 * @Last Modified time: 2016-01-05 08:25:20
 */

'use strict';
define(function(require, exports, module) {
    
    var Chart = require('./chart');
    var mapSetting = {
        selector: '#map',
        margin: {
            left: 0,
            right: 0,
            top: 20,
            bottom: 20
        },
        dataset: [],
        colorset: ['#6ebeff', '#fff']
    }

    var mapReload = function(callback) {

        Chart.addChinaMap('#map', function() {
            if (callback) {

                callback()
            }
        })
    }

        function mapChart() {

            Chart.addChinaMap(mapSetting, function() {

                var parent = d3.select('#map').select('.content'),
                    dataset = []

                    function getMapData() {

                        $.ajax({
                            url: path + "/customerBehavior/getHotword",
                            type: "GET",
                            dataType: "json",
                            success: function(data) {

                                if (data.areaName === '') {

                                    return
                                }

                                dataset = [data.areaName, data.hotWord]

                                var width = document.querySelector(mapSetting.selector).getBoundingClientRect().width,
                                    height = document.querySelector(mapSetting.selector).getBoundingClientRect().height

                                    Chart.addCircle(parent, width, height, dataset)
                            },
                            error: function() {
                                return "error";
                            }
                        })
                    }

                var intervel = setInterval(function() {
                    getMapData()
                }, 1000)
            })

            $('.tip').live('click', function(e) {

                var e = e || window.event,
                    word = $(this).html()

                    window.location.href = path + '/search?keyword=' + word
            })
        }
    module.exports = mapChart;
})