(function () {
  'use strict';
  angular
    .module('app')
    .controller('languageController', languageController);


  /** @ngInject */
  function languageController($translate, $location, $locale,$scope) {
    var vm = this;
    var currentLocal = $locale.id.substring(0, 2);

    vm.currentLocale = currentLocal;
    vm.changeLanguage = function (locale) {
      $translate.use(locale);
      $location.search('lang', locale);
      vm.currentLocale = locale;
    }
  }
})();

/*
(function () {
'use strict';
var langController = angular.module('languageControllers',['languageServices']);

langController.controller('languageController',['$translate','$location','$locale',
  function($scope,$translate,$location,$locale){
    var currentLocal = $locale.id.substring(0,2);

    vm.currentLocale = currentLocal;
    $scope.changeLanguage = function(locale){
      $translate.use(locale);
      $location.search('lang',locale);
      vm.currentLocale=locale;
    }
  }])
})();
*/
