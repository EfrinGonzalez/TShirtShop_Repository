angular.module('app.controllers', []).controller('TshirtListController', function($scope, $state, popupService, $window, Tshirt) {
  $scope.tshirts = Tshirt.query(); //fetch all tshirts. Issues a GET to /api/shop/tshirts

  $scope.deleteTshirt = function(tshirt) { // Delete a Tshirt. Issues a DELETE to /api/v1/shipwrecks/:id
    if (popupService.showPopup('Really delete this?')) {
      tshirt.$delete(function() {
        $scope.tshirts = Tshirt.query(); 
        $state.go('tshirts');
      });
    }
  };
}).controller('TshirtViewController', function($scope, $stateParams, Tshirt) {
  $scope.tshirt = Tshirt.get({ id: $stateParams.id }); //Get a single shipwreck.Issues a GET to /api/v1/shipwrecks/:id
}).controller('TshirtCreateController', function($scope, $state, $stateParams, Tshirt) {
  $scope.tshirt = new Tshirt();  //create new shipwreck instance. Properties will be set via ng-model on UI

  $scope.addTshirt = function() { //create a new shipwreck. Issues a POST to /api/v1/shipwrecks
    $scope.tshirt.$save(function() {
      $state.go('tshirts'); // on success go back to the list i.e. shipwrecks state.
    });
  };
}).controller('TshirtEditController', function($scope, $state, $stateParams, Tshirt) {
  $scope.updateTshirt = function() { //Update the edited shipwreck. Issues a PUT to /api/v1/shipwrecks/:id
    $scope.tshirt.$update(function() {
      $state.go('tshirt'); // on success go back to the list i.e. shipwrecks state.
    });
  };

  $scope.loadTshirt = function() { //Issues a GET request to /api/v1/shipwrecks/:id to get a shipwreck to update
    $scope.tshirt = Tshirt.get({ id: $stateParams.id });
  };

  $scope.loadTshirt(); // Load a shipwreck which can be edited on UI
});
