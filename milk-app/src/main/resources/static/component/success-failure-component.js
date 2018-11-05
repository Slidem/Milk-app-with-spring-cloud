class SuccessFailureComponent{

    constructor(successModalId, failureModalId) {
        this._successModal = $(successModalId);
        this._failureModal = $(failureModalId);
    }

    showSuccess(){
        this._successModal.modal('toggle');
    }

    showFailure(){
        this._failureModal.modal('toggle');
    }

}