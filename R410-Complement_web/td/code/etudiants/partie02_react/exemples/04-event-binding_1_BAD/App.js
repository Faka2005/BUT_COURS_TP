


class Toggle extends React.Component {
    constructor(props) {
        super(props);
        this.state = {isToggleOn: true};
        this.handleClick=this.handleClick.bind(this);
    }

    render() {
        return (
            <button onClick={this.handleClick}>
                {this.state.isToggleOn ? 'ON' : 'OFF'}
            </button>
        );
    }
    handleClick() {
        console.log(this)
        this.setState(state => ({
            isToggleOn: !state.isToggleOn
        }));
    }

}



const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <div>
        <Toggle/>
        <Toggle/>
    </div>
);

