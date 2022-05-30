$('#add').click(function () {
  const one = document.getElementById('num1').value;
  const two = document.getElementById('num2').value;
  var URL = '/addition?num1=' + one + '&num2=' + two;
  $.ajax({
    method: "GET",
    url: URL,
    success: function (response) {
      document.getElementById('result').setAttribute('value', response);
    }
  })
})

$('#sub').click(function () {
  const one = document.getElementById('num1').value;
  const two = document.getElementById('num2').value;
  var URL = '/subtraction?num1=' + one + '&num2=' + two;
  $.ajax({
    method: "GET",
    url: URL,
    success: function (response) {
      document.getElementById('result').setAttribute('value', response);
    }
  })
})

$('#multi').click(function () {
  const one = document.getElementById('num1').value;
  const two = document.getElementById('num2').value;
  var URL = '/multiplication?num1=' + one + '&num2=' + two;
  $.ajax({
    method: "GET",
    url: URL,
    success: function (response) {
      document.getElementById('result').setAttribute('value', response);
    }
  })
})

$('#div').click(function () {
  const one = document.getElementById('num1').value;
  const two = document.getElementById('num2').value;
  var URL = '/division?num1=' + one + '&num2=' + two;
  $.ajax({
    method: "GET",
    url: URL,
    success: function (response) {
      document.getElementById('result').setAttribute('value', response);
    }
  })
})
