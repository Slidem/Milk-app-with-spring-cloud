class TableComponent{

    constructor(url){
        this._url = url;
    }

    generateTable(usersCallBack){
        let table = TableComponent._createTable();
        let users = [];
        $.getJSON(this._url, function(userPurchases){
            userPurchases.forEach(up =>{
                let user = up.user;
                let userName = user.firstName + ' ' + user.lastName;
                let row = new MilkTableRow(userName);
                up.purchases.forEach(p => {
                    row.addPurchase(p.quantity, p.buyDate);
                });
                table.addTableRow(row);
                users.push(user);
            });
            usersCallBack(users);
        });
        table.generate();
    }

    static _createTable() {
        let properties = new MilkTableProperties('#milk-table-container', ['table']);
        return new MilkTableComponents(properties);
    }
}