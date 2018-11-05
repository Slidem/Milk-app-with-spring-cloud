class BuyMilkModalComponent {
    constructor(modalConatinerId, buyMilkService, tableComponent){
        let qc = new QuantitySelectComponent();
        let usc = new UserSelectComponent();
        let bmc = new BuyMilkButtonComponent(buyMilkService, qc, usc);
        this._modalContainerId = modalConatinerId;
        this._quantityComponent = qc;
        this._userSelectComponent = usc;
        this._milkButtonComponent = bmc;
        this._tableComponent = tableComponent;
    }

    generate(){
        let modalDialog = $('<div class="modal-dialog modal-lg"></div>');
        let modalContent = $('<div class="modal-content"></div>');
        let userAndQuantityRow = $('<div class="row"></div>');
        let buttonRow = $('<div class="row text-center confirm-buy-milk-container"></div>');

        modalDialog.append(modalContent);
        modalContent.append(userAndQuantityRow);
        modalContent.append(buttonRow);

        userAndQuantityRow.append(this._userSelectComponent.getContainer());
        userAndQuantityRow.append(this._quantityComponent.getContainer());

        buttonRow.append(this._milkButtonComponent.getButton());

        //generate
        $(this._modalContainerId).append(modalDialog);
    }

    getUserSelectComponent(){
        return this._userSelectComponent;
    }
}

