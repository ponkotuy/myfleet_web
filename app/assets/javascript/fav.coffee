$(document).ready ->
  loadFavCounter()

@loadFavCounter = () ->
  $('.favorite-group').each (i, elem) ->
    path = $(elem).attr('data-path')
    path ?= location.pathname + location.search + location.hash
    counter = $(elem).find('.fav-counter')
    counter.each -> favCounter(counter, path)

favCounter = (counter, path) ->
  $.get('/rest/v1/fav_count/' + encodeURIComponent(path))
    .done (data) ->
      counter.val(data)
