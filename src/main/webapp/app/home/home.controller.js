var HomeController = app.controller('HomeController', 
['$scope', 'Principal', 'LoginService', '$state', 'HomeService', '$q', function($scope, Principal, LoginService, $state, HomeService, $q) {
    
    HomeService.get(
        {
            url: 'get-vnlover-home'
        },
        function(dat) {
            console.log(dat)
            $scope.vnLoverInfo = dat['info']['data']
            $scope.rating = dat['rating']

            $scope.top10Locations = dat['top10_locations']
            $scope.top10Locations.forEach(function(v,k) {
                console.log(v[0]+": "+v[1])
            })

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
            // draw rating chart
            Highcharts.chart('rating_chart', {
                chart: {
                    type: 'bar'
                },
                title: {
                    text: 'Đánh giá'
                },
                xAxis: {
                    categories: ['5 sao', '4 sao', '3 sao', '2 sao', '1 sao'],
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Người',
                        align: 'high'
                    },
                    labels: {
                        overflow: 'justify'
                    }
                },
                tooltip: {
                    valueSuffix: ' người'
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
                    name: 'Người',
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
                        text: 'Thống kê bài đăng theo ngày'
                    },
                    series: [{
                        name: 'bài đăng',
                        data: data_post_timestamp,
                        tooltip: {
                            valueDecimals: 2
                        }
                    }]
                });
            })

            pph_hour = []
            pph_posts = []
            pph_reaction_like = []
            pph_reaction_love = []
            pph_reaction_haha = []
            pph_reaction_wow = []
            pph_reaction_sad = []
            pph_reaction_angry = []
            pph_reaction_all = []
            dat['post_per_hours'].forEach(function(v,k) {
                pph_hour.push(v[0])
                pph_posts.push(v[1])
                pph_reaction_like.push(parseInt(v[2]/v[1]))
                pph_reaction_love.push(parseInt(v[3]/v[1]))
                pph_reaction_haha.push(parseInt(v[4]/v[1]))
                pph_reaction_wow.push(parseInt(v[5]/v[1]))
                pph_reaction_sad.push(parseInt(v[6]/v[1]))
                pph_reaction_angry.push(parseInt(v[7]/v[1]))
                pph_reaction_all.push(parseInt(v[8]/v[1]))
            })

            console.log(dat['post_per_hours'])

            // draw post_per_hours chart
            Highcharts.chart('post_per_hour', {
                chart: {
                    type: 'line'
                },
                title: {
                    text: 'Thống kê bài đăng mỗi giờ'
                },
                xAxis: {
                    categories: pph_hour
                },
                yAxis: {
                    title: {
                        text: 'Số bài đăng'
                    }
                },
                plotOptions: {
                    line: {
                        dataLabels: {
                            enabled: true
                        },
                        enableMouseTracking: false
                    }
                },
                series: [{
                    name: 'Bài đăng',
                    data: pph_posts
                },
                // {
                //     name: 'Like',
                //     data: pph_reaction_like
                // },
                // {
                //     name: 'Haha',
                //     data: pph_reaction_haha
                // },
                // {
                //     name: 'Love',
                //     data: pph_reaction_love
                // },
                // {
                //     name: 'Wow',
                //     data: pph_reaction_wow
                // },
                // {
                //     name: 'Sad',
                //     data: pph_reaction_sad
                // },
                // {
                //     name: 'Angry',
                //     data: pph_reaction_angry
                // },
                // {
                //     name: 'Tương tác',
                //     data: pph_reaction_all
                // }
                ]
            });

            //draw tuong tac chart
            Highcharts.chart('pph_reaction_all', {
                chart: {
                    type: 'line'
                },
                title: {
                    text: 'Thống kê lượt tương tác mỗi giờ'
                },
                xAxis: {
                    categories: pph_hour
                },
                yAxis: {
                    title: {
                        text: 'Số bài đăng'
                    }
                },
                plotOptions: {
                    line: {
                        dataLabels: {
                            enabled: true
                        },
                        enableMouseTracking: false
                    }
                },
                series: [{
                    name: 'Tương tác',
                    data: pph_reaction_all
                }
                ]
            });

        },
        function(err) {
            console.log(err)
        }
    )

    
}]);
