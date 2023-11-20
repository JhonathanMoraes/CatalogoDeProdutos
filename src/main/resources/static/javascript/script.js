let valorFinal = document.querySelector('#valorFinal');

function calcular() {
    let txtPreco = document.querySelector('#preco').value;
    let checkDescontoNatal = document.querySelector('#descontoNatal');
    let checkDescontoPersonalizado = document.querySelector('#descontoPersonalizado');
    let txtTaxaDesconto = document.querySelector('#taxaDesconto');
    
    console.log(checkDescontoNatal.checked);
    console.log(checkDescontoPersonalizado.checked);
    
    if(checkDescontoNatal.checked){
        txtPreco = txtPreco * 0.90;
    }
    if(checkDescontoPersonalizado.checked){
        txtTaxaDesconto.removeAttribute('disabled');
        txtPreco = txtPreco - txtTaxaDesconto.value * (txtPreco/100);
    } else {
        txtTaxaDesconto.setAttribute('disabled', '');
    }
    valorFinal.innerText = txtPreco;
};

