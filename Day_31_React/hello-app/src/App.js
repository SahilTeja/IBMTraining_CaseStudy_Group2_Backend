
import './App.css';
import LoginForm from './components/LoginForm';
import Parent from './components/Parent';
import Toggle from './components/Toggle';
import Login from './components/Login'

// import Demo from './components/Demo'
// import Show from './components/Show'
// import Chow from './components/Show'

function App() {
  return (
    <div>
      <h3>**** it renders from App.js ****</h3>
      <h3>hello and welcome to react app</h3>
      {/* <hr />
      <Demo />
      <hr />
      <Show author = "Harsh" />
      <Chow author = "Anand" /> */}
      <hr />
      <Parent />
      <hr />
      <LoginForm />
      <hr />
      <Toggle />
      <hr />
      <Login />

    </div>
  );
}

export default App;
