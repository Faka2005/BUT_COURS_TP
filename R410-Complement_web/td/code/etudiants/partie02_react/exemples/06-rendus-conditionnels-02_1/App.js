"use strict"
class UserGreeting extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
            <h1>Bienvenue !</h1>
        );
    }
}

class GuestGreeting extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
            <h1>Veuillez vous inscrire.</h1>
        );
    }
}

class Greeting extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        if (this.props.isLoggedIn) {
            return <UserGreeting />;
        }
        return <GuestGreeting />;
    }
}

class LoginButton extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
            <button onClick={this.props.onClick}>
                Connexion
            </button>
        );
    }
}

class LogoutButton extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
            <button onClick={this.props.onClick}>
                Déconnexion
            </button>
        );
    }
}

class LoginControl extends React.Component {
    constructor(props) {
        super(props);
        this.handleLoginClick = this.handleLoginClick.bind(this);
        this.handleLogoutClick = this.handleLogoutClick.bind(this);
        this.state = {isLoggedIn: false};
    }

    handleLoginClick() {
        this.setState({isLoggedIn: true});
    }

    handleLogoutClick() {
        this.setState({isLoggedIn: false});
    }

    render() {
        const isLoggedIn = this.state.isLoggedIn;
        let button;
        if (isLoggedIn) {
            button = <LogoutButton onClick={this.handleLogoutClick} />;
        } else {
            button = <LoginButton onClick={this.handleLoginClick} />;
        }

        return (
            <div>
                <Greeting isLoggedIn={isLoggedIn} />
                {button}
            </div>
        );
    }
}

const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(<LoginControl/>);

