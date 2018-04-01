var app = angular.module('vnLoversApp', [
    'ngStorage',
    'ngResource',
    'ngCookies',
    'ngAria',
    'ngCacheBuster',
    'ngFileUpload',
    'ui.bootstrap',
    'ui.bootstrap.datetimepicker',
    'ui.router',
    'infinite-scroll',
    // jhipster-needle-angularjs-add-module JHipster will add new module here
    'angular-loading-bar'
]).run(['stateHandler', function(stateHandler) {
    stateHandler.initialize();
}])

    

