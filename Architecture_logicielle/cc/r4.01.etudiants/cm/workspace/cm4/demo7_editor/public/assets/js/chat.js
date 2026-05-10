
Vue.use( CKEditor );

let socket = io();

const app = new Vue( {
    el: '#app',
    vuetify: new Vuetify(),
    data: {
        editor: ClassicEditor,
        editorData: '',
        editorConfig: { },

    },
    methods : {
        onEditorInput : function() {
            console.log('emit : '+ this.editorData);
            socket.emit("on-editor-input", this.editorData);

        }
    },
    mounted(){
        socket.on('broadcast-data', (data) => {
            this.editorData = data;
        })
    }

});

socket.on('init-data',function(data){
    app.editorData = data;
});




