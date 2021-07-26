<template>
  <card>
    <h4 slot="header" class="card-title">Edit Profile</h4>
    <form>
      <div class="row">
      
        <div class="col-6">
          <base-input type="text"
                    label="Nickname"
                    placeholder="Nickname"
                    v-model="user.nickname">
          </base-input>
        </div>
        <div class="col-6">
          <base-input type="text"
                    label="Username"
                    placeholder="Username"
                    :disabled="true"
                    v-model="user.username">
          </base-input>
        </div>
        
      </div>

      <div class="row">
        <div class="col">
          <base-input type="email"
                    label="Email"
                    placeholder="Email"
                    v-model="user.email">
          </base-input>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12">
          <div class="form-group">
            <label>About Me</label>
            <textarea rows="4" class="form-control border-input"
                      placeholder="Here can be your description"
                      v-model="user.aboutMe">
              </textarea>
          </div>
        </div>
      </div>
      <div class="text-center d-flex justify-content-end">
        <button type="submit" class="btn btn-info btn-fill mx-3" @click="updateProfile">
          Save
        </button>
        <button type="submit" class="btn btn-danger btn-fill" @click="cancelUpdate">
          Cancel
        </button>
      </div>
      <div class="clearfix"></div>
    </form>
  </card>
</template>
<script>
  import Card from 'src/components/Cards/Card.vue'

  export default {
    components: {
      Card
    },
    data () {
      return {
        user: {
          company: 'Light dashboard',
          username: 'michael23',
          nickname: 'hahahoho',
          email: '',
          firstName: 'Mike',
          lastName: 'Andrew',
          address: 'Melbourne, Australia',
          city: 'melbourne',
          country: 'Australia',
          postalCode: '',
          aboutMe: `Lamborghini Mercy, Your chick she so thirsty, I'm in that two seat Lambo.`
        }
      }
    },
    methods: {
      updateProfile () {
        // 프로필 수정하는 axios 요청
        this.$emit("change")
      },
      cancelUpdate () {
        this.$emit("change")
      }
    }
  }

</script>
<style>

</style>
