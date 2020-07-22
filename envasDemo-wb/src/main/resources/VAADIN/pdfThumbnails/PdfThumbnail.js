window.com_neopsis_envas_demo_javascript_PdfThumbnail = function () {

  var elem = this.getElement(), self = this
  var pdfThumbElem = null, oldTriggerRepaintValue = '0'

  if (typeof pdfjsLib === 'undefined') {
    throw Error('pdf.js is not loaded. Please include it before pdfThumbnails.js.')
  }
  pdfjsLib.disableWorker = true

  this.onStateChange = function (e) {
    var state = this.getState()

    // a little hack to only reinitialized the component when needed
    if (oldTriggerRepaintValue != state.triggerRepaint) {
      oldTriggerRepaintValue = state.triggerRepaint

      // remove all elements within elem
      elem.innerHTML = ''

      var url = state.resources && state.resources.pdf
      if (typeof url !== 'undefined') {
        url = this.translateVaadinUri(url.uRL)
      } else {
        url = state.url
      }

      pdfThumbElem = document.createElement('img')
      pdfThumbElem.classList.add('pdf-thumb-elem')
      pdfThumbElem.setAttribute('style', 'max-width: 100%; max-height: 100%;margin: 0 auto;display: inline-block;')
      if (state.link) {
        var linkElem = document.createElement('a')
        linkElem.setAttribute('href', url)
        linkElem.setAttribute('target', '_blank')
        linkElem.append(pdfThumbElem)
        elem.appendChild(linkElem)
      } else {
        elem.appendChild(pdfThumbElem)
      }

      pdfjsLib.getDocument(url).then(function (pdf) {
        pdf.getPage(1).then(function (page) {
          var canvas = document.createElement('canvas')
          var viewport = page.getViewport(1.0)
          var context = canvas.getContext('2d')

          if (state.previewWidth) {
            viewport = page.getViewport(state.previewWidth / viewport.width)
          } else if (state.previewHeight) {
            viewport = page.getViewport(state.previewHeight / viewport.height)
          }

          canvas.height = viewport.height
          canvas.width = viewport.width

          page.render({
            canvasContext: context,
            viewport: viewport
          }).then(function () {
            pdfThumbElem.src = canvas.toDataURL()
          })
        }).catch(function () {
          console.log('pdfThumbnails error: could not open page 1 of document ' + url + '. Not a pdf ?')
        })
      }).catch(function () {
        console.log('pdfThumbnails error: could not find or open document ' + url + '. Not a pdf ?')
      })
    }
  }

}