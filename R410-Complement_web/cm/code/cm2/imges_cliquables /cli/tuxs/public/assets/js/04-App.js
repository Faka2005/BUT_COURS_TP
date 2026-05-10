const useState = React.useState
function MonImage(props) {
        return (
            <img src={"./assets/images/"+props.src+"_tux.png"} alt=""/>
        )
}

//Le choix a été fait de ne pas hériter
function MonImageCliquable(props) {
    const doOnclick = (e) => {
        props.update(props.src)
    }

    return <img src={"./assets/images/"+props.src+"_tux.png"} alt="" onClick={doOnclick} />
}


function App()  {
    const images = ["nowhite", "pax"]
    const [currentImage, setImage] = useState(images[0])
    const  doUpdate = (name) => {
        setImage(name)
    }
    return (
            <div>
                <div id="images">
                    {images.map(name => <MonImageCliquable src={name} key={name} update={doUpdate} />)}
                </div>
                <div id="image">
                    <MonImage src={currentImage}/>
                </div>
            </div>
        )

}



const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <App />);
