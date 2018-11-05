class UserSelectComponent {

    constructor(){
        this._select = this._createSelect();
        this._container = this._createContainer();
    }


    populateFromUsers(users){
        let slct = this._select;
        users.forEach(u =>{
            let userName = '' + u.firstName + ' ' + u.lastName;
            let option = $("<option/>", {
                value: u.id,
                text: userName
            });
            slct.append(option);
        });
        return slct;
    }

    getContainer(){
        return this._container;
    }

    getSelectedUserId(){
        return parseInt(this._select.val());
    }

    _createSelect() {
        return $('<select class="form-control" id="user-select-input"></select>');
    }

    _createContainer() {
         let container = $('<div class="col-md-6 user-select text-center"></div>');
         container.append(this._select);
         return container;
    }

}

