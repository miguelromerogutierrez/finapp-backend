import React from 'react';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';

import Dropdown, {Item} from './dropdown';

import './styles.scss';

interface Props {
  amount: String,
  alias: String,
  bankName: String,
  type: String
}

const AccountCard : React.FC<Props> = (props) => {
  const items : Array<Item> = [
    { text: "Add Transaction", value: "transaction" },
    { text: "Edit Account", value: "edit" },
    { text: "See Detail", value: "details" }
  ];

  const handleSelectItem = (event: React.MouseEvent, value: String) => {
    console.log(value);
  };

  return (
  <Grid container className="account-card" component={Paper}>
    <Dropdown items={items} onSelectItem={handleSelectItem} />
    <Grid item xs={12} className="account-card--right">
      <span>{props.bankName}</span>
      <span>{props.alias}</span>
    </Grid>
    <Grid item xs={12} className="account-card--left">
      <span>{props.type}</span>
      <span className="money">{props.amount}</span>
    </Grid>
  </Grid>
  );
};

export default AccountCard;
