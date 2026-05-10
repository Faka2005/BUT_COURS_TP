"use strict"
class MyForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            text: ""
        };

       this.handleInputChange = this.handleInputChange.bind(this);
    }

    handleInputChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const type = target.type;

        this.setState({
            text : value +' '+type
        });
    }

    render() {
        return (

            <form>
                <p> {this.state.text} </p>
                    <input
                        type="checkbox"
                        onChange={this.handleInputChange} />
                    <input
                        type="number"
                        onChange={this.handleInputChange} />

            </form>
        );
    }
}

const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(<MyForm />);

