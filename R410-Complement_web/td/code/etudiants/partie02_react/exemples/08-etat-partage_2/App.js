const {useState} = React
const scaleNames = {
    c: 'Celsius',
    f: 'Fahrenheit'
};

const toCelsius = (fahrenheit) => {
    return (fahrenheit - 32) * 5 / 9;
}

const toFahrenheit= (celsius) => {
    return (celsius * 9 / 5) + 32;
}

const tryConvert= (temperature, convert) =>{
    const input = parseFloat(temperature);
    if (Number.isNaN(input)) {
        return '';
    }
    const output = convert(input);
    const rounded = Math.round(output * 1000) / 1000;
    return rounded.toString();
}

const BoilingVerdict = ({celsius}) =>
        (celsius >= 100)?
            <p>The water would boil.</p>
        : <p>The water would not boil.</p>


const TemperatureInput=({onTemperatureChange,temperature,scale}) =>{
    const handleChange=(e) => onTemperatureChange(e.target.value);
    return (
            <fieldset>
                <legend>Enter temperature in {scaleNames[scale]}:</legend>
                <input value={temperature}
                       onChange={handleChange} />
            </fieldset>
        )
}

const Calculator = ()=>  {
        const [temperature,setTemperature]=useState('')
        const [scale, setScale]=useState('c')

    const handleCelsiusChange = (temperature) => {
        setScale('c')
        setTemperature(temperature)
    }

    const handleFahrenheitChange=(temperature) =>{
        setScale('f')
        setTemperature(temperature)
    }

    const celsius = scale === 'f' ? tryConvert(temperature, toCelsius) : temperature
    const fahrenheit = scale === 'c' ? tryConvert(temperature, toFahrenheit) : temperature;

        return (
            <div>
                <TemperatureInput
                    scale="c"
                    temperature={celsius}
                    onTemperatureChange={handleCelsiusChange} />
                <TemperatureInput
                    scale="f"
                    temperature={fahrenheit}
                    onTemperatureChange={handleFahrenheitChange} />
                <BoilingVerdict
                    celsius={parseFloat(celsius)} />
            </div>
        );

}
const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(<Calculator />);

