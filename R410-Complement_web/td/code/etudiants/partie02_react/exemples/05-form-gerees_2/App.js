const { useState } = React
const MyForm = () =>  {
    const [text,  setText] = useState("")
        const handleInputChange= (event) =>{
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const type = target.type;
        setText(value +' '+ type);}

    return (

            <form>
                <p> {text} </p>
                    <input
                        type="checkbox"
                        onChange={handleInputChange} />
                    <input
                        type="number"
                        onChange={handleInputChange} />

            </form>
        );

}

const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(<MyForm />);

