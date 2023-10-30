# Practice Problems

## Random
* [Add Two Numbers as list in reverse](./two_numbers/AddReverseNumberAsList.java)
* Find two numbers whose sum as target number
    * [Moving Inward](./two_sum/TwoSumByMovingInward.java)
    * [By Sorting](./two_sum/TwoSumBySorting.java)

## Committing
In order to commit to personal git repository in gitu hub do following:
1. edit `./.git/config`
2. add `sshCommand = ssh -i ~/.ssh/id_rsa_personal` under `[core]` section
   1. `id_rsa_personal` is the access key in that location that should be present   
3. then run `git push` (assuming `git add` and `git commit` already done)

### Reference
1. [More details here in this post-comments section](https://gist.github.com/jexchan/2351996)
2. Ran into some ssh issues with git. Used following Posts to resolve: 
   1. https://github.blog/2023-03-23-we-updated-our-rsa-ssh-host-key/
   2. https://docs.github.com/en/authentication/troubleshooting-ssh/error-permission-denied-publickey
   3. https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account
   4. 
