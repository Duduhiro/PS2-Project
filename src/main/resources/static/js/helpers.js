function allowOnlyLetters(input) {
    input.value = input.value.replace(/[^a-zA-Z\s]/g, '');
}

function allowOnlyEmails(input) {
    input.value = input.value.replace(/[^a-zA-Z\w.@]/g, '');
}

function invertDateFormat(dateString) {
    // Split the input string by "-"
    var parts = dateString.split("-");
    
    // Rearrange the parts to form the inverted date format
    var invertedDateString = parts[2] + "-" + parts[1] + "-" + parts[0];
    
    // Return the inverted date string
    return invertedDateString;
}