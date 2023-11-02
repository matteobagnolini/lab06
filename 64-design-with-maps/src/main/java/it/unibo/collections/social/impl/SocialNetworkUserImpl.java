/**
 * 
 */
package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:  think of what type of keys and values would best suit the requirements
     */

     private Map<String, Set<U>> followedInGroup;

    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.followedInGroup = new HashMap<>();
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        if (this.followedInGroup.containsKey(circle)) {
            return this.followedInGroup.get(circle).add(user);
        } else {
            Set<U> newCircleSet = new HashSet<>();
            newCircleSet.add(user); 
            this.followedInGroup.put(circle, newCircleSet);
            return true;
        }    
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        Set<U> followedGroup = new HashSet<>();
        if (this.followedInGroup.containsKey(groupName)) {
            followedGroup.addAll(this.followedInGroup.get(groupName));
            return followedGroup;
        }
        return followedGroup;
    }

    @Override
    public List<U> getFollowedUsers() {
        Set<U> totalFollowed = new HashSet<>();
        for (Set<U> set : this.followedInGroup.values()) {
            totalFollowed.addAll(set);
        }
        return new LinkedList<U>(totalFollowed);
    }
}
