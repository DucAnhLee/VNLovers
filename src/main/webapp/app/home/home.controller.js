var HomeController = app.controller('HomeController', 
['$scope', 'Principal', 'LoginService', '$state', 'HomeService', '$q', function($scope, Principal, LoginService, $state, HomeService, $q) {
    
    HomeService.get(
        {
            url: 'get-vnlover-home'
        },
        function(dat) {
            console.log(dat)
            $scope.vnLoverInfo = dat['info']['data']

            data = []
            dat['rating']['rating_star'].forEach(function(v,k) {
                if (k == 0) {
                    v = 1;
                }
                v = parseInt(v)
                data.push(v)
            })
            console.log(data)
            console.log($scope.vnLoverInfo['rating_count'])
            data[0] = $scope.vnLoverInfo['rating_count'] - data[1] - data[2] - data[3] - data[4]
            Highcharts.chart('rating_chart', {
                chart: {
                    type: 'bar'
                },
                title: {
                    text: 'Rating Analytic'
                },
                xAxis: {
                    categories: ['5 stars', '4 stars', '3 stars', '2 stars', '1 stars'],
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'People',
                        align: 'high'
                    },
                    labels: {
                        overflow: 'justify'
                    }
                },
                tooltip: {
                    valueSuffix: ' people'
                },
                plotOptions: {
                    bar: {
                        dataLabels: {
                            enabled: true
                        }
                    }
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'top',
                    x: -40,
                    y: 80,
                    floating: true,
                    borderWidth: 1,
                    backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
                    shadow: true
                },
                credits: {
                    enabled: false
                },
                series: [{
                    name: 'People',
                    data: data
                }]
            });

            //draw post timestamp chart
            data_post_timestamp = []
            dat['post_timestamp'].forEach(function(v,k) {
                data_post_timestamp.push([v[0], v[1]])
            })

            $q.all(data_post_timestamp).then(function() {
                Highcharts.stockChart('post_timestamp', {
                rangeSelector: {
                    selected: 1
                },

                title: {
                    text: 'Post Frequently'
                },
                series: [{
                    name: 'posts',
                    data: data_post_timestamp,
                    tooltip: {
                        valueDecimals: 2
                    }
                }]
            });
            })

        },
        function(err) {
            console.log(err)
        }
    )

    // HomeService.get(
    //     {
    //         url: 'get-vnlovers-info'
    //     },
    //     function(dat) {
    //         $scope.vnLoverInfo = dat.data;
    //     },
    //     function(err) {
    //         console.log(err)
    //     }
    // );

    // draw rating chart
    // HomeService.get(
    //     {
    //         url: "get-vnlovers-rating"
    //     },
    //     function(dat) {
    //         data = []
    //         dat['rating_star'].forEach(function(v,k) {
    //             if (k == 0) {
    //                 v = 1;
    //             }
    //             v = parseInt(v)
    //             data.push(v)
    //         })
    //         data[0] = $scope.vnLoverInfo['rating_count'] - data[1] - data[2] - data[3] - data[4]
    //         Highcharts.chart('rating_chart', {
    //             chart: {
    //                 type: 'bar'
    //             },
    //             title: {
    //                 text: 'Rating Analytic'
    //             },
    //             xAxis: {
    //                 categories: ['5 stars', '4 stars', '3 stars', '2 stars', '1 stars'],
    //             },
    //             yAxis: {
    //                 min: 0,
    //                 title: {
    //                     text: 'People',
    //                     align: 'high'
    //                 },
    //                 labels: {
    //                     overflow: 'justify'
    //                 }
    //             },
    //             tooltip: {
    //                 valueSuffix: ' people'
    //             },
    //             plotOptions: {
    //                 bar: {
    //                     dataLabels: {
    //                         enabled: true
    //                     }
    //                 }
    //             },
    //             legend: {
    //                 layout: 'vertical',
    //                 align: 'right',
    //                 verticalAlign: 'top',
    //                 x: -40,
    //                 y: 80,
    //                 floating: true,
    //                 borderWidth: 1,
    //                 backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
    //                 shadow: true
    //             },
    //             credits: {
    //                 enabled: false
    //             },
    //             series: [{
    //                 name: 'People',
    //                 data: data
    //             }]
    //         });

    //     },
    //     function(err) {
    //         console.log(err)
    //     }
    // )

    //draw post frequently chart 
    // HomeService.query(
    //     {
    //         url: 'get-posts-timestamp'
    //     },
    //     function(dat) {
    //         console.log(dat);
    //         data = []
    //         dat.forEach(function(v,k) {
    //             data.push([v[0], v[1]])
    //         })

    //         $q.all(data).then(function() {
    //             Highcharts.stockChart('post_timestamp', {
    //             rangeSelector: {
    //                 selected: 1
    //             },

    //             title: {
    //                 text: 'Post Frequently'
    //             },
    //             series: [{
    //                 name: 'posts',
    //                 data: data,
    //                 tooltip: {
    //                     valueDecimals: 2
    //                 }
    //             }]
    //         });
    //         })
                
    //     },
    //     function(err) {
    //         console.log(err)
    //     }
    // )


}]);
