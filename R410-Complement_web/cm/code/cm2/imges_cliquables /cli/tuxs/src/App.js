import logo from './logo.svg';
import './App.css';
import MonImage from "./MonImage";
import MonImageCliquable from "./MonImageCliquable";
import {useState} from "react";

function App() {

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

export default App;
