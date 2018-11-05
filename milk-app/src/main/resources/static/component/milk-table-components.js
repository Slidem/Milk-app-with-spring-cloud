class MilkTableRow {

  constructor(userName) {
    this._userName = userName;
    this._row = $('<tr><td class="users-column">' + userName + '</td></tr>');
  }

  getRow() {
    return this._row;
  }

  addPurchase(quantity, date) {
    let tableCell = $('<td class="users-milk-purchase"></td>');
    for (let i = 0; i < quantity; i++) {
      tableCell.append(this._addDot(date));
    }
    this._row.append(tableCell);
  }

  _addDot(dateString){
      let date = new Date(dateString);
      return $('<span class="dot" data-toggle="tooltip" data-placement="top" title="' + date.toDateString() + '"></span>');
  }
}


class MilkTableProperties {

  constructor(containerId, tableClasses) {
    this._containerId = containerId;
    this._tableClasses = tableClasses;
  }

  getConatinerId() {
    return this._containerId;
  }

  getTableClasses() {
    return this._tableClasses;
  }
}


class MilkTableComponents {

  constructor(milkTableProperties) {
    this._milkTableProperties = milkTableProperties;
    this._table = $("<table><tbody></tbody></table>");
  }

  generate() {
    let tableClasses = this._milkTableProperties.getTableClasses();
    let milkTable = this._table;

    tableClasses.forEach(tableClass => {
      milkTable.addClass(tableClass);
    });

    let tableContainer = $(this._milkTableProperties.getConatinerId());
    tableContainer.empty();
    tableContainer.append(milkTable);
  }

  addTableRow(milkTableRow) {
    this._table.append(milkTableRow.getRow());
  }
}



