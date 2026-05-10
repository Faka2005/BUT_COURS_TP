const { useState } = React
const UserGreeting = () => <h1>Bienvenue !</h1>
const GuestGreeting  = () => <h1>Veuillez vous inscrire.</h1>
const Greeting = ({isLoggedIn}) =>
        isLoggedIn ? <UserGreeting />: <GuestGreeting />

const LoginButton=({onClick}) =>
            <button onClick={onClick}>
                Connexion
            </button>

const LogoutButton = ({onClick}) =>
                <button onClick={onClick}>
                Déconnexion
            </button>

const LoginControl = () => {
    const [isLoggedIn, toggle] = useState(false)
    const handleLoginClick= () => {
        toggle(true);
    }
    const handleLogoutClick = () => {
        toggle(false);
    }
    const button = (isLoggedIn) ?
            <LogoutButton onClick={handleLogoutClick} /> :
            <LoginButton onClick={handleLoginClick} />;


    return (
            <div>
                <Greeting isLoggedIn={isLoggedIn} />
                {button}
            </div>
        );

}

const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(<LoginControl/>);

