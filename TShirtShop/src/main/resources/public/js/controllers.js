angular.module('app.controllers', []).controller('TshirtListController', function($scope, $state, popupService, $window, Tshirt) {
  $scope.tshirts = Tshirt.query(); //fetch all tshirts. Issues a GET to /api/shop/tshirts
  
  $scope.deleteTshirt = function(tshirt) { // Delete a Tshirt. Issues a DELETE to /api/shop/tshirts/:id
    if (popupService.showPopup('Really delete this?')) {
      tshirt.$delete(function() {
        $scope.tshirts = Tshirt.query(); 
        $state.go('tshirts');
      });
    }
  };
}).controller('TshirtViewController', function($scope, $stateParams, Tshirt) {
  $scope.tshirt = Tshirt.get({ id: $stateParams.id }); //Get a single TShirt. Issues a GET to /api/shop/tshirts/:id
}).controller('TshirtCreateController', function($scope, $state, $stateParams, Tshirt) {
  $scope.tshirt = new Tshirt();  //create new tshirt instance. Properties will be set via ng-model on UI

  $scope.addTshirt = function() { //create a new tshirt. Issues a POST to /api/shop/tshirts
    $scope.tshirt.$save(function() {
      $state.go('tshirts'); // on success go back to the list i.e. tshirts state.
    });
  };
}).controller('TshirtEditController', function($scope, $state, $stateParams, Tshirt) {
  $scope.updateTshirt = function() { //Update the edited tshirt. Issues a PUT to /api/shop/tshirts/:id
    $scope.tshirt.$update(function() {
      $state.go('tshirts'); // on success go back to the list i.e. tshirts state.
    });
  };

  $scope.loadTshirt = function() { //Issues a GET request to /api/shop/tshirts/:id to get a tshirt to update
    $scope.tshirt = Tshirt.get({ id: $stateParams.id });
  };

  $scope.loadTshirt(); // Load a tshirt which can be edited on UI
});
