angular.module('app.services', []).factory('Tshirt', function($resource) {
  return $resource('/api/shop/tshirts/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
