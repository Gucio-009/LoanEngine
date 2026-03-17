import './App.css';
import axios from 'axios';
import React, { useState } from 'react';

const api = axios.create({
  baseURL: 'http://localhost:8080/'
});

function App() {

  const isFormValid = () => {
  return form.personalCode.length === 11 && 
         form.amount >= 2000 && 
         form.amount <= 10000 &&
         form.period >= 12 && 
         form.period <= 60;
  };

  const [form, setForm] = useState({ personalCode: '', amount: 4000, period: 12 });
  const [res, setRes] = useState(null);

  const check = async () => {
    try {
      const response = await api.post('api/loan/check', form);
      setRes(response.data);
    } catch (error) {
      console.error(error);
      alert("Something went wrong, server has an issue");
    }
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h2>Loan Calculator</h2>
      <input placeholder="Personal Code" onChange={e => setForm({...form, personalCode: e.target.value})} /><br/>
      <input type="number" value={form.amount} onChange={e => setForm({...form, amount: e.target.value})} /> loan amount (€)<br/>
      <input type="number" value={form.period} onChange={e => setForm({...form, period: e.target.value})} /> loan period<br/>
      <button onClick={check} disabled={!isFormValid()}>Check</button>

      {res && (
        <div style={{ marginTop: '20px', border: '1px solid black', padding: '10px' }}>
          <h3>Decision: {res.approved ? "POSITIVE" : "NEGATIVE"}</h3>
          {res.approved ? 
          (
            <p>We can give you <b>{res.amount} €</b> for <b>{res.period}</b> months</p>
          ) : (
            <p style={{ color: 'red' }}>Reason for refusal: <b>{res.message}</b></p>
          )}
        </div>
      )}
    </div>
  );
}

export default App;
