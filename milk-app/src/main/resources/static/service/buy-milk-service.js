class BuyMilkService {

    constructor(url, generateTableComponent, successFailureComponent) {
        this._url = url;
        this._generateTableComponent = generateTableComponent;
        this._successFailureComponent = successFailureComponent;
    }

    buyMilk(userId, quantity) {

        let requestBody = {
            "userId": userId,
            "quantity": quantity
        };

        let tableComponent = this._generateTableComponent;
        let successFailureComponent = this._successFailureComponent;
        let url = this._url;

        $.ajax({
            url:url,
            type:"POST",
            data: JSON.stringify(requestBody),
            contentType:"application/json; charset=utf-8",
            dataType:"json",
            success: function(){
                tableComponent.generateTable(u => u);
                successFailureComponent.showSuccess();
            },
            error: function(){
                successFailureComponent.showFailure();
            }
        });

    }

}