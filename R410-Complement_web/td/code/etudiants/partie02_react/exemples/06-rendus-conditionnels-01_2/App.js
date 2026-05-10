const { useState } = React
const UserGreeting = () => <h1>Bienvenue !</h1>
const GuestGreeting = ()=> <h1>Veuillez vous inscrire.</h1>


const Greeting = ({isLoggedIn}) =>
         (isLoggedIn) ?  <UserGreeting /> : <GuestGreeting />


const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <div>
    <Greeting isLoggedIn={false}/>
        <Greeting isLoggedIn={true}/>
    </div>
        );

