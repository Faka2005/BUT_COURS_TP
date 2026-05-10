const { useState} = React
const Toggle = ()=> {
    const [isToggleOn, toggle] = useState(true)
     const   handleClick = ()=> {
        toggle(!isToggleOn)
     }

    return (
            <button onClick={() => handleClick()}>
                {isToggleOn ? 'ON' : 'OFF'}
            </button>
        );
}



const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(
    <div>
        <Toggle/>
        <Toggle/>
    </div>
);

