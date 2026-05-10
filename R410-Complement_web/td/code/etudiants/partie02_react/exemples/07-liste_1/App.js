"use strict"

class Blog extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        const sidebar = (
            <ul>
                {this.props.posts.map((post) =>
                    <li key={post.id}>
                        {post.title}
                    </li>
                )}
            </ul>
        )
        const content = this.props.posts.map((post) =>
            <div key={post.id}>
                <h3>{post.title}</h3>
                <p>{post.content}</p>
            </div>
        );
        return (
            <div>
                {sidebar}
                <hr/>
                {content}
            </div>
        );
    }
}
const posts = [
    {id: 1, title: 'Bonjour, monde', content: 'Bienvenue sur la doc de React !'},
    {id: 2, title: 'Installation', content: 'Vous pouvez installer React depuis npm.'}
];
const root = ReactDOM.createRoot(document.querySelector('#app_container'));
root.render(<Blog posts={posts} />);

