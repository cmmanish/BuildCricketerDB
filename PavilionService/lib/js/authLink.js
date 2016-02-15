/**
 * Created by mmadhusoodan on 9/2/15.
 */
<script LANGUAGE="JavaScript">
$(document).ready(function () {
    instagramAuthURL = "https://api.instagram.com/oauth/authorize/?client_id=a60a41e5bc3d440e9ddb6f50160df41b&redirect_uri=http://localhost:4002/redirect&response_type=code";
    $("a.authLink").attr("href", instagramAuthURL);
});
</script>