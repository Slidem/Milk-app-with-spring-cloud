//TODO: put together everything
// - generate tables and modals
// - missing !!! --> delete last purchase

const PURCHASES_PATH = '/purchases';

function addScript(appUri, path){
    $('head').append('<script src="' + appUri + path + '"></script>');
}

function init(appUri){
    //use json for ajax calls
    $.ajaxSetup({
        contentType: "application/json; charset=utf-8"
    });

    //import scripts
    addScript(appUri, '/component/milk-table-components.js');
    addScript(appUri, '/component/success-failure-component.js');
    addScript(appUri, '/component/table-component.js');
    addScript(appUri, '/service/buy-milk-service.js');
    addScript(appUri, '/component/user-select-component.js');
    addScript(appUri, '/component/quantity-select-component.js');
    addScript(appUri, '/component/buymilk-button-component.js');
    addScript(appUri, '/component/buymilk-modal-component.js');

    //initiate components
    let successFailureComponent = new SuccessFailureComponent('#success-modal', '#failure-modal');
    let generateTableService = new TableComponent(appUri + PURCHASES_PATH);
    let buyMilkService = new BuyMilkService(appUri + PURCHASES_PATH, generateTableService, successFailureComponent);
    let buyMilkModalComponent = new BuyMilkModalComponent('#buy-milk-modal', buyMilkService, generateTableService);

    //generate table and purchase modal
    let populateUsersCallback = users => buyMilkModalComponent.getUserSelectComponent().populateFromUsers(users);
    generateTableService.generateTable(populateUsersCallback);
    buyMilkModalComponent.generate();
}




