class MonImage extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        return (
            <img src={"./assets/images/"+this.props.src+"_tux.png"} alt=""/>
        )
    }
}



class App extends React.Component {

    render() {
        return (
            <div>
                <div id="images">
                    <MonImage src="nowhite"/>
                    <MonImage src="pax"/>
                    </div>
                <div id="image">
                    <MonImage src="nowhite"/>
                </div>
            </div>
        )
    }
}



const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <App />);
