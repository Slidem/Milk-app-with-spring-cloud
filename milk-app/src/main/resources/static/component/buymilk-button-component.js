class BuyMilkButtonComponent {

    constructor(buyMilkService, quantityComponent, userSelectComponent) {
        this._buyMilkService = buyMilkService;
        this._quantityComponent = quantityComponent;
        this._userSelectComponent = userSelectComponent;
        this._button = this._createButton();
    }

    getButton() {
        return this._button;
    }

    _createButton() {
        let button = $('<button type="button" id="buy-button" class="btn btn-info"></button>');
        let text = ' Buy ';
        let icon = $('<span class="glyphicon glyphicon-shopping-cart"></span>');
        button.append(text);
        button.append(icon);

        let buyMilkService = this._buyMilkService;
        let userSelectComponent = this._userSelectComponent;
        let quantityComponent = this._quantityComponent;

        button.click(function () {
            let userId = userSelectComponent.getSelectedUserId();
            let quantity = quantityComponent.getValue();
            buyMilkService.buyMilk(userId, quantity);
            $('#buy-milk-modal').modal('toggle');
        });

        return button;
    }
}