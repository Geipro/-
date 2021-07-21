<template>
  <card>
    <h4 slot="header" class="card-title">My Profile</h4>
    <form>
      <div class="row">
        <div class="col-6">
          <base-input type="text"
                    label="Nickname"
                    placeholder="Nickname"
                    :disabled="true"
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
        <div class="col-6">
          <base-input type="email"
                    label="Email"
                    :disabled="true"
                    placeholder="Email"
                    v-model="user.email">
          </base-input>
        </div>

        <div class="col-6 d-flex justify-content-center align-items-end mb-1">
          <div class="btn btn-warning w-100 mb-3">Change Password</div>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12">
          <div class="form-group">
            <label>About Me</label>
            <textarea rows="4" class="form-control border-input"
                      :disabled="true"
                      placeholder="Here can be your description"
                      v-model="user.aboutMe">
              </textarea>
          </div>
        </div>
      </div>
      <div class="text-center">
        <a class="btn btn-info btn-fill float-right" @click="goUpdateProfile">
          Update Profile
        </a>
      </div>
      <div class="clearfix"></div>
    </form>
  </card>
  
</template>
<script>
  import Card from 'src/components/Cards/Card.vue'
import BaseInput from '../../components/Inputs/BaseInput.vue'

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
      goUpdateProfile () {
        this.$emit("change")
      }
    }
  }

</script>
<style>

</style>
