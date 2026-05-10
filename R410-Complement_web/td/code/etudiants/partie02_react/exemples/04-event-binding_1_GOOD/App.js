class ClickableButton extends React.Component {
    constructor(props) {
        super(props);
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(e){
        console.log(e)
    }

    render() {
        return (
            <button onClick={this.handleClick}>
                Click
            </button>
        );
    }

}

const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <div>
        <ClickableButton/>
    </div>
);

