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

//Le choix a été fait de ne pas hériter
class MonImageCliquable extends React.Component{
    constructor(props) {
        super(props);
        this.doOnclickBinded = this.doOnclickBinded.bind(this)
    }

    doOnclick(e) {
        console.log(e.target.src)
        console.log(this) //undefined
    }

    doOnclickBinded() {
        console.log(this.props.src)
    }

    render() {
        return (
            /*
            <img src={"./assets/images/"+this.props.src+"_tux.png"} alt="" onClick={()=>console.log(this.props.src)} />
            <img src={"./assets/images/"+this.props.src+"_tux.png"} alt="" onClick={this.doOnclick} />
             */
            <img src={"./assets/images/"+this.props.src+"_tux.png"} alt="" onClick={this.doOnclickBinded} />

        )
    }
}


class App extends React.Component {
    constructor(props) {
        super(props);
        this.images = ["nowhite", "pax"]
        this.state = {currentImage : this.images[0]}
    }


    render() {
        return (
            <div>
                <div id="images">
                    {this.images.map(name => <MonImageCliquable src={name} key={name}/>)}
                </div>
                <div id="image">
                    <MonImage src={this.state.currentImage}/>
                </div>
            </div>
        )
    }
}



const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <App />);
