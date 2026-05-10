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
        this.isLoggedIn = props.isLoggedIn;
    }
    render() {
        if (this.isLoggedIn) {
            return <UserGreeting />;
        }
        return <GuestGreeting />;
    }
}

const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <div>
    <Greeting isLoggedIn={false}/>
<Greeting isLoggedIn={true}/>
    </div>);

