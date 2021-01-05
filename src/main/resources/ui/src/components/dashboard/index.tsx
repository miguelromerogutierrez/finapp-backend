import React from 'react';
import AccountCard from '../account-card';
import Container from '@material-ui/core/Container'

export default function Dashboard() {
  const data = [
    { amount: '$12,000.00', alias: 'Main Acct.', bankName: 'BBVA', type: 'Debit' },
    { amount: '$1,200.00', alias: 'Main Acct. 2', bankName: 'BBVA', type: 'Debit' },
    { amount: '$100.00', alias: 'Main Acct. 3', bankName: 'BBVA', type: 'Credit' },
    { amount: '$2,000.00', alias: 'Main Acct. 4', bankName: 'BBVA', type: 'Saves' },
    { amount: '$20.00', alias: 'Main Acct. 5', bankName: 'BBVA', type: 'Invest' },
  ];
  return (
    <Container>
      {data.map(el => <AccountCard {...el} />)}
    </Container>
  )
}