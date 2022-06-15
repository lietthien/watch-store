const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);
// move to top and sticky header
let movetotop = $('#move-to-top');
let headerdown = $('.header-down')
let headerup = $('.header-up')
document.onscroll = () => {
    if (document.body.scrollTop > 30 || document.documentElement.scrollTop > 30) {
        movetotop.style.display = 'flex'
    } else {
        movetotop.style.display = 'none'
    }
    if (document.body.scrollTop >= headerup.offsetHeight || document.documentElement.scrollTop >= headerup.offsetHeight) {
        headerdown.style.position = 'fixed'
        headerdown.style.top = 0
        headerup.style.marginBottom = headerdown.offsetHeight + 'px'
    } else {
        headerdown.style.position = 'initial'
        headerup.style.marginBottom = 0
    }
}
movetotop.onclick = () => {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}
// manual and auto navigate slider
const radioBtns = $$('.manual-btn');
radioBtns.forEach(element => {
    element.onclick = () => {
        $('.manual-btn.active').classList.remove('active')
        element.classList.add('active')
    }
});
function autoNavigateslider() {
    let counter = 0;
    setInterval(() => {
        radioBtns[counter].click();
        counter++;
        if (counter > 3) {
            counter = 0;
        }
    }, 5000);
}
// tab best seller product
function bestSellerPopup() {
    const watchTypeItems = $$('.watches-type-item')
    const bestSellerItems = $$('.best-seller-item')
    const moreBsellerLinks = $$('.more-bseller-link')
    watchTypeItems.forEach((element, index) => {
        let bestSellerItem = bestSellerItems[index]
        let moreBsellerLink = moreBsellerLinks[index]
        element.onclick = () => {
            $('.watches-type-item.active').classList.remove('active')
            element.classList.add('active')
            $('.best-seller-item.active').classList.remove('active')
            bestSellerItem.classList.add('active')
            $('.more-bseller-link.active').classList.remove('active')
            moreBsellerLink.classList.add('active')
        }
    });

}
// tab newest product

function newestProductPopup() {
    const newWatchTypeItems = $$('.newest-watches-type-item')
    const newProductItems = $$('.newest-product-item')
    const moreNewProductLinks = $$('.more-newest-product-link')
    newWatchTypeItems.forEach((element, index) => {
        let newProductItem = newProductItems[index]
        let moreNewProductLink = moreNewProductLinks[index]
        element.onclick = () => {
            $('.newest-watches-type-item.active').classList.remove('active')
            element.classList.add('active')
            $('.newest-product-item.active').classList.remove('active')
            newProductItem.classList.add('active')
            $('.more-newest-product-link.active').classList.remove('active')
            moreNewProductLink.classList.add('active')
        }
    });

}
;(function tabDetailInfo(){
    $$('.infor-item-link').forEach((element,index) => {
        element.onclick = () => {
            $('.infor-item-link.onfocus').classList.remove('onfocus')
            element.classList.add('onfocus')
            $('.infor-item-des.onfocus').classList.remove('onfocus')
            $$('.infor-item-des')[index].classList.add('onfocus')
        }
    });
})();

autoNavigateslider();
bestSellerPopup();
newestProductPopup();

