const MIN_MILK_QUANTITY = 1;
const MAX_MILK_QUANTITY = 3;

class QuantitySelectComponent {

    constructor() {
        this._container = this._createQuantitySelectContainer();
        this._upButton = this._createUpButton();
        this._downButton = this._createDownButton();
        this._quantity = this._createQuanityDiv();
        this._setupContainer();
        this._setupButtonsBehaviour();
    }

    getContainer() {
        return this._container;
    }

    getValue() {
        return parseInt(this._quantity.html());
    }

    _createQuantitySelectContainer() {
        return $('<div class="col-md-6 user-select text-center"></div>');
    }

    _createUpButton() {
        return $('' +
            '<div id="quantity-up">' +
            '<span class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span>' +
            '</div>');
    }

    _createDownButton() {
        return $(
            '<div id="quantity-down">' +
            '<span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>' +
            '</div>');
    }

    _createQuanityDiv() {
        return $('<div id="quantity">1</div>');
    }


    _setupContainer() {
        this._container.append(this._upButton);
        this._container.append(this._quantity);
        this._container.append(this._downButton);
    }

    _setupButtonsBehaviour() {
        let q = this._quantity;
        this._upButton.click(function () {
            let newValue = parseInt(q.html()) + 1;
            if (newValue > MAX_MILK_QUANTITY) {
                return;
            }
            q.html(newValue);
        });

        this._downButton.click(function () {
            let newValue = parseInt(q.html()) - 1;
            if (newValue < MIN_MILK_QUANTITY) {
                return;
            }
            q.html(newValue);
        });
    }

}