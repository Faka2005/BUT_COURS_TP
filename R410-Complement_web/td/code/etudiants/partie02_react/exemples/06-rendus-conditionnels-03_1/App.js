"use strict"
class WarningBanner extends React.Component {
    constructor(props) {
        super(props);
    }
    render() {
        if (!this.props.warn) {
            return null;
        }

        return (
            <div className="warning">
                Attention !
            </div>
        );
    }
}

class Page extends React.Component {
    constructor(props) {
        super(props);
        this.state = {showWarning: true};
        this.handleToggleClick = this.handleToggleClick.bind(this);
    }

    handleToggleClick() {
        this.setState(state => ({
            showWarning: !state.showWarning
        }));
    }

    render() {
        return (
            <div>
                <WarningBanner warn={this.state.showWarning} />
                <button onClick={this.handleToggleClick}>
                    {this.state.showWarning ? 'Masquer' : 'Afficher'}
                </button>
            </div>
        );
    }
}
const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(<Page />);

