const app = Vue.createApp({});
app.component('dynamic-form', {
    template: `
    <div id="vue-input">
        <div class="row">
            <input v-model="cityNameField" class="col-3" placeholder="Stadtname" ref="nameInput">
            <input v-model="holidayWishField" class="col-3" placeholder="Urlaubswunsch z. B. gerne" @keyup.enter="save()">
            <button type="button" class="col-3" id="save-btn" @click="save()">Save</button>
        </div>
    </div>
    <div id="vue-table-fields">
        <table class="table table-striped table-hover">
        <caption>Here are all of your Dream Cities</caption>
            <thead>
                <tr>
                    <th>Stadtname</th>
                    <th>Urlaubswunsch</th>
                </tr>
            </thead>
            <tbody>
                <tr v-if="wunschStaedte.length === 0">
                    <td colspan="2">No Dream Cities yet</td>
                </tr>
                <tr v-for="wunschStadtEntity in wunschStaedte">
                    <td>{{wunschStadtEntity.stadtName}}</td>
                    <td>{{wunschStadtEntity.urlaubsWunsch}}</td>
                </tr>
                <tr>
                    <td>{{cityNameField}}</td>
                    <td>{{holidayWishField}}</td>
                </tr>
            </tbody>
        </table>
    </div>
    `,
    data() {
        return {
            wunschStaedte: [],
            cityNameField: '',
            holidayWishField: '',
        };
    },
    methods: {
        loadCities() {
            axios.get('/getCitiesJson')
                .then(response => (this.wunschStaedte = response.data))
        },
        save() {
            axios.post('/saveCityJson', {
                stadtName: this.cityNameField,
                urlaubsWunsch: this.holidayWishField
            })
                .then((response) => {
                    this.cityNameField = '';
                    this.holidayWishField = '';
                    this.$refs.nameInput.focus();
                    this.loadCities();
                }, (error) => {
                    console.log('Could not save city!');
                });
        },
    },
    mounted: function() {
        this.loadCities();
    }
});
app.mount('#dynamic-form')