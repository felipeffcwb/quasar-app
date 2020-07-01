import { http } from 'boot/axios'
import { Loading } from 'quasar'
import { notifySucces, notifyError } from '../../exceptions/errors.custom'

const addInfluencers = ({ dispatch }, payload) => {
  debugger
  Loading.show({
    delay: 400 // ms
  })
  http.post('influencer/add/influencer', payload)
    .then(response => {
      debugger
      Loading.hide()
      notifySucces(response.status)
      dispatch('getInfluencer')
    })
    .catch(error => {
      debugger
      console.log(error.message)
      Loading.hide()
      notifyError(error.message)
    })
}

const getInfluencer = ({ commit }) => {
  debugger
  Loading.show({
    delay: 400 // ms
  })
  http.get('influencer/list')
    .then(response => {
      debugger
      Loading.hide()
      commit('SET_INFLUENCERS', { response })
    })
    .catch(error => {
      debugger
      console.log(error.message)
      Loading.hide()
    })
}

const deleteInfluencer = ({ dispatch }, payload) => {
  debugger
  Loading.show({
    delay: 400 // ms
  })
  http.delete('influencer/delete/influencer/' + payload.id)
    .then(response => {
      debugger
      Loading.hide()
      notifySucces(response.status)
      dispatch('getInfluencer')
    })
    .catch(error => {
      debugger
      console.log(error.message)
      Loading.hide()
      notifyError(error.message)
    })
}

const updateInfluencer = ({ dispatch }, payload) => {
  debugger
  Loading.show({
    delay: 400 // ms
  })
  http.put('influencer/delete/influencer/' + payload.id)
    .then(response => {
      debugger
      Loading.hide()
      notifySucces(response.status)
      dispatch('getInfluencer')
    })
    .catch(error => {
      debugger
      console.log(error.message)
      Loading.hide()
      notifyError(error.message)
    })
}

export default {
  addInfluencers,
  getInfluencer,
  deleteInfluencer,
  updateInfluencer
}
